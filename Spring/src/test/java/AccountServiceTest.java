import com.cjh.domain.Account;
import com.cjh.service.IAccountService;
import com.cjh.utils.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService  accountService;
    @Test
    public void testSaveAccount(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        Account account=new Account();
        account.setName("黑马程序员");
        account.setMoney(10000f);
        accountService.save(account);
    }
    @Test
    public void testFindAccountById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        accountService.findById(1);
    }
    @Test
    public void testUpdateAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        Account account=accountService.findById(1);
        account.setMoney(20301050f);
        accountService.update(account);
    }
    @Test
    public void testDeleteAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        accountService.delete(1);
    }
    @Test
    public void findAll(){
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        List<Account> accounts = accountService.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
}
