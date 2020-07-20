package patient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.MappingConstants;

@RestController
@RequestMapping(value = MappingConstants.PATIENT)
public class PatientController {
}
