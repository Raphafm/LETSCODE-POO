package org.example.Menus;

import java.util.Objects;
import java.util.Scanner;

import org.example.Repository.RepositoryProdutos;
import org.example.Telas.AcessarConta;
import org.example.Telas.CriarConta;
import org.example.model.Corretora;
import org.example.model.Usuario;
import org.example.simulacao.Simulacao;

public class MenuPrincipal {
    private static final Scanner sc = new Scanner(System.in);

    public static void menuPrincipal() {

        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:\n0 - Sair\n1 - Fazer o login\n2 - Criar conta\n3 - Fazer simulação");
        System.out.print("Opcao: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "0":
                System.out.println("Obrigado por utilizar nossos serviços, até a próxima");
                return;
            case "1":
                Usuario usuario = AcessarConta.executar(sc);
                // verifica se é corretora ou cliente
                if (Objects.isNull(usuario)) {
                    System.err.println("Usuario não encontrado!");
                } else if (usuario instanceof Corretora) {
                    MenuCorretora.menuCorretora(sc, usuario);
                } else {
                    MenuCliente.menuCliente(sc);
                }
                break;
            case "2":
                new CriarConta().excecutar(sc);
                break;
            case "3":
                System.out.println("simulação em construção");
                Simulacao meuInvestimento = new Simulacao(RepositoryProdutos.getInvestimento().getRentabilidadeAnual().doubleValue());
                meuInvestimento.relatorio();
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuPrincipal();
    }
}
