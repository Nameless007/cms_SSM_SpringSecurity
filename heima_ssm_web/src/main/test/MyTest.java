import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyTest {
    @Test
    public void test1(){
//        $2a$10$Vd65cJxg.aQmTFYUJnbvCOiL4IVfdqbEjjKLLWkerjDg6OGNQO.WW
//        $2a$10$oAATv.gyQIAGy2CK5XUQ2Oe5Qk6dm/GbSIrCNvBqLAmebetJ/D6ES
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }
}
