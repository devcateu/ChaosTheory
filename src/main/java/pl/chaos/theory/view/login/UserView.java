package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.util.Request;

@Component("user")
@Request
public class UserView extends UserDto {
}
