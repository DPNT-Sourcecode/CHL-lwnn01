package befaster.solutions.HLO;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloWorldSolution {
    private HelloSolution helloSolution;
    @Before
    public void setUp() {
        helloSolution = new HelloSolution();

    }

    @Test
    public void sayHello() {
        assertThat(helloSolution.hello("Alun"), equalTo("Hello, Alun!"));
    }

    @Test
    public void sayHello2() {
        assertThat(helloSolution.hello(""), equalTo("Hello,!"));
        assertThat(helloSolution.hello(null), equalTo("Hello,!"));
    }
}



