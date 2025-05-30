import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class SubmitServiceTest {

    SubmitService service = new SubmitService();

    @Test
    public void testSubmitTaskSuccess() {
        Map<String, Object> result = service.submitTask("224141201", "SIT707_1.1P", "report.pdf");

        assertEquals("success", result.get("status"));
        assertEquals("224141201", result.get("studentId"));
        assertEquals("SIT707_1.1P", result.get("taskId"));
        assertEquals("report.pdf", result.get("fileName"));
        assertNotNull(result.get("submittedAt"));
    }

    @Test
    public void testSubmitTaskWithMissingFields() {
        Map<String, Object> result = service.submitTask("", "SIT707_1.1P", "report.pdf");

        assertEquals("error", result.get("status"));
        assertEquals("Missing input data", result.get("message"));
    }


    @Test
    public void testFailCase() {
        assertEquals("Hello, fail", service.submitTask("Test","", "")); // This will fail
    }
}
