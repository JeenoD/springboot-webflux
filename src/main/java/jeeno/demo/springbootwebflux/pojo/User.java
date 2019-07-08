package jeeno.demo.springbootwebflux.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author: Jeeno
 * @mail: jeenocruise@gmail.com
 * @date: 2019/7/5 17:40
 */
@Data
@ToString
public class User {
    private String username;
    private String password;
}
