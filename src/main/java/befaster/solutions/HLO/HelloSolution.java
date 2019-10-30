package befaster.solutions.HLO;


import com.google.common.base.Strings;

public class HelloSolution {
    public String hello(String friendName) {
        return String.format("Hello, %s!", Strings.isNullOrEmpty(friendName) ? "" : friendName);
    }
}




