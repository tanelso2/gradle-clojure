package gradle_clojure.plugin.clojure.internal;

import gradle_clojure.plugin.clojure.tasks.ClojureSourceSet;
import org.gradle.api.Action;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;

public class DefaultClojureSourceSet implements ClojureSourceSet {
  private final SourceDirectorySet clojure;

  public DefaultClojureSourceSet(String name, ObjectFactory objects) {
    this.clojure = objects.sourceDirectorySet(name, name);
    this.clojure.getFilter().include("**/*.clj", "**/*.cljc");
  }

  @Override
  public SourceDirectorySet getClojure() {
    return clojure;
  }

  @Override
  public ClojureSourceSet clojure(Action<? super SourceDirectorySet> configureAction) {
    configureAction.execute(clojure);
    return this;
  }
}
