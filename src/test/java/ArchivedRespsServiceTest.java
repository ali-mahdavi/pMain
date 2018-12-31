import com.pooyaco.powercard.services.*;
import com.pooyaco.utils.DateUtils;
import com.pooyaco.utils.JalaliDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by a.mahdavi on 9/15/2018.
 */

@ContextConfiguration({
        "classpath*:dispatcher-servlet-test.xml"

})
@EnableWebMvc
@Configuration
@WebAppConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class ArchivedRespsServiceTest {


    @Autowired
    ArchivedRespsService archivedRepsService;

    @Autowired
    ArchivedRespsSuspectService archivedRepSuspectService;

    @Autowired
    ArchivedRespsMaliService archivedRespsMaliService;

    @Autowired
    HsmKeyServices hsmKeyServices;

    @Autowired
    CutOfAmountService cutoffamountService;

    @Autowired
    CutOffAmountAfterService cutoffamountAfterService;


    @Test
    public void testFindAll() {
        archivedRepsService.getAll();
    }

    @Test
    public void testFindByReportName() {
        archivedRespsMaliService.findArchievedList("Report02","1397/06/29","201");
    }

    @Test
    public void testEditArchieved() {
        archivedRespsMaliService.updateArchieved("Report02","1397/06/29","201","253","1397-03-5");
    }

    @Test
    public void testHsmServices() {
        hsmKeyServices.getHsmKey("maskan");
    }

    @Test
    public void testCutOffAmountService() {
        //cutoffamountService.fetchCutOfInfo("1393-11-19","254",new String[]{"004164"});
        //cutoffamountService.fetchCutOfInfo("1393-11-19","254",null);
        JalaliDate jalaliCalendar= DateUtils.convertGregorianToJalali(2018,12,05);
        System.out.println(jalaliCalendar.toString());
    }

    @Test
    public void testAfterCutOffAmountService() {
        cutoffamountAfterService.fetchAfterCutOf("1397-07-02","01111101");

    }




    @Test
    public void testMD5Hash(){
      String password="secret";
        Md5PasswordEncoder passwordEncoder=new Md5PasswordEncoder();
        String hashedPassword=passwordEncoder.encodePassword(password,null);
        System.out.println(hashedPassword);
    }


}
