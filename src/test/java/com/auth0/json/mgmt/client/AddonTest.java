package com.auth0.json.mgmt.client;

import com.auth0.JsonMatcher;
import com.auth0.json.JsonTest;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AddonTest extends JsonTest<Addon> {

    private static final String json = "{\"a-boolean\":true,\"a-string\":\"string\"}";

    @Test
    public void shouldSerialize() throws Exception {
        Addon addon = new Addon();
        addon.setProperty("a-boolean", true);
        addon.setProperty("a-string", "string");

        String serialized = toJSON(addon);
        assertThat(serialized, is(notNullValue()));
        assertThat(serialized, JsonMatcher.hasEntry("a-boolean", true));
        assertThat(serialized, JsonMatcher.hasEntry("a-string", "string"));
    }

    @Test
    public void shouldDeserialize() throws Exception {
        Addon addon = fromJSON(json, Addon.class);

        assertThat(addon, is(notNullValue()));

        assertThat(addon.getProperties(), IsMapContaining.hasEntry("a-boolean", (Object) true));
        assertThat(addon.getProperties(), IsMapContaining.hasEntry("a-string", (Object) "string"));
        assertThat(addon.getProperty("a-boolean"), is((Object) true));
        assertThat(addon.getProperty("a-string"), is((Object) "string"));
    }
}