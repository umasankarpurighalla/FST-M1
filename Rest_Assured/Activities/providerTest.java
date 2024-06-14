package liveprojects;

import java.security.PublicKey;

public class providerTest {

    @Provider ("userProvider")
    @PactFolder("target/pacts")
    public class ProviderTest {

        @BeforeEach
        Public void setUp(PactverificationContext context){
            HttpTestTarget target = new HttpTestTarget(host "loalhost", post 8585);
            context.setTarget(target);

        }

        @TestTemplet

        @ExtendWith(PartVerificationInvocationcontextProvider.class)
        public void provideTest()



        @State("POST Request")
        public void state1() {}
    }
}
