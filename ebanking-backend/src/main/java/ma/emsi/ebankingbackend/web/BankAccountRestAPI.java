package ma.emsi.ebankingbackend.web;

import lombok.AllArgsConstructor;
import ma.emsi.ebankingbackend.dtos.AccountHistoryDTO;
import ma.emsi.ebankingbackend.dtos.AccountOperationDTO;
import ma.emsi.ebankingbackend.dtos.BankAccountDTO;
import ma.emsi.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccountById(@PathVariable String accountId) {
        return null;
    }}