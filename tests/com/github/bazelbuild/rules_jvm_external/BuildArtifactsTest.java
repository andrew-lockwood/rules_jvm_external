package com.github.bazelbuild.rules_jvm_external;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import com.google.common.reflect.ClassPath;
import java.io.IOException;
import org.junit.Test;

public class BuildArtifactsTest {
  @Test
  public void test_excludedArtifacts_notOnClassPath() throws IOException {
    ClassPath classPath = ClassPath.from(ClassLoader.getSystemClassLoader());
    assertThat(classPath.getTopLevelClasses("io.envoyproxy.pgv.grpc"), hasSize(3));
    assertThat(classPath.getTopLevelClasses("io.envoyproxy.pgv"), hasSize(17));
    assertThat(classPath.getTopLevelClasses("io.envoyproxy.pgv.validate"), hasSize(1));
  }
}
