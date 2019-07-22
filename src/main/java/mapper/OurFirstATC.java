package mapper;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.UISteps;

import java.util.Arrays;
import java.util.List;

public class OurFirstATC extends JUnitStories {

        public OurFirstATC() {
            super();
            this.configuredEmbedder().candidateSteps().add(new UISteps());
        }

        @Override
        public Configuration configuration() {
            return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
                    .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFailureTrace(true)
                            .withFormats(Format.CONSOLE, Format.STATS, Format.HTML, Format.TXT));
        }

        @Override
        public List<CandidateSteps> candidateSteps() {
            return new InstanceStepsFactory(configuration(), this).createCandidateSteps();

        }

        @Override
        protected List<String> storyPaths() {
            return Arrays.asList("OurFirstATC.story");
            //List<String> storyPaths = new LinkedList<String>();
            //storyPaths.add("stories/OurFirstATC.story");
            //return storyPaths;
            //return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
            //return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/*.story"), null);
        }

}