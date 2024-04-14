package api.wikimedia.org.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:env.properties"})
public interface EnvConfig extends Config {

    @Config.Key("url.base")
    String url();

    @Config.Key("auth.token")
    String token();
}
