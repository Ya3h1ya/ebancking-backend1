package ma.emsi.ebankingbackend.services;

import jakarta.transaction.Transactional;
import ma.emsi.ebankingbackend.entities.BankAccount;
import ma.emsi.ebankingbackend.entities.CurrentAccount;
import ma.emsi.ebankingbackend.entities.SavingAccount;
import ma.emsi.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter() {
        BankAccount bankAccount =
                bankAccountRepository.findById("031a8b82-8f06-4ef6-aa6b-7eb130c80772").orElse(null);
        if (bankAccount != null) {
            System.out.println("**************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getAmount() + "\t" + op.getAmount());
            });

        }
    }
}
