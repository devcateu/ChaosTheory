package pl.chaos.theory.algorithm;

import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.data.MapEntry;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.chaos.theory.BaseSpringTest;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AlgorithmCSVParserTest extends BaseSpringTest {

	@Autowired
	private AlgorithmCSVParser algorithmCSVParser;

	@Test
	public void testParse_wrongSeparator_shouldThrowError() throws Exception {
		final String csv = "a;64.43";
		assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
			public void call() throws Throwable {
				algorithmCSVParser.parse(csv);
			}
		}).isInstanceOf(WrongLineInCSVFile.class)
				.hasMessageContaining(csv);
	}

	@Test
	public void testParse_wrongNumberOfParameter_shouldThrowError() throws Exception {
		final String csv = "a,2,3";
		assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
			public void call() throws Throwable {
				algorithmCSVParser.parse(csv);
			}
		}).isInstanceOf(WrongLineInCSVFile.class)
				.hasMessageContaining(csv);
	}

	@Test
	public void correctParse_2lines() throws IOException {
		Map<String, Double> parameterValues = null;
		try {
			parameterValues = algorithmCSVParser.parse("a,1\nb,2");
		} catch (Exception e) {
		}

		assertThat(parameterValues).containsOnly(new MapEntry[]{MapEntry.entry("a", 1.), MapEntry.entry("b", 2.)});
	}

	@Test
	public void repeatedKey_shouldThrowError() throws IOException {
		final String csv = "paramMAMA,100000\nparamMAMA,343222";
		assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
			public void call() throws Throwable {
				algorithmCSVParser.parse(csv);
			}
		}).isInstanceOf(RepeatedParameterException.class)
				.hasMessageContaining("paramMAMA")
				.hasMessageContaining("100000")
				.hasMessageContaining("343222");
	}
}