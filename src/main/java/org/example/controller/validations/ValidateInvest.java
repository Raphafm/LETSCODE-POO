package org.example.controller.validations;

import org.example.controller.service.ToInvest;
import org.example.model.Client;
import org.example.repository.RepositoryInvestment;

import java.util.Objects;

public class ValidateInvest {
    public static boolean run(Client client){
       return Objects.isNull(RepositoryInvestment.getInvestmentList(client.getId()));
    }
}
