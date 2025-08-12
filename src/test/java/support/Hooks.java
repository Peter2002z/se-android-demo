package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private final MobileWorld mobileWorld;

    public Hooks(MobileWorld mobileWorld) {
        this.mobileWorld = mobileWorld;
    }

    @Before
    public void setUp() throws Exception {
        mobileWorld.launchApp();
    }

    @After
    public void tearDown() {
        mobileWorld.closeApp();
    }
}
