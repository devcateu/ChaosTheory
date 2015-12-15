package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.util.Request;

@Component("password")
@Request
public class PasswordView extends PasswordDto {
}
