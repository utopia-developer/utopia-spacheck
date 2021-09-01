import org.gradle.api.Project;
import org.gradle.api.plugins.quality.CheckstyleExtension;
import org.gradle.api.plugins.quality.FindBugsExtension;
import org.gradle.api.plugins.quality.PmdExtension;
import utils.DestinationUtil;

import javax.annotation.Nonnull;
import java.io.File;

public class UtopiaSpaCheckExtension {

    @Nonnull
    private final CheckStyleOptions checkStyle = new CheckStyleOptions();

    @Nonnull
    private final FindBugsOptions findBugs;

    @Nonnull
    private final PmdOptions pmd;

    @Nonnull
    private final CoverageReportOptions coverageReport;


    private class CheckStyleOptions extends CheckstyleExtension {

        private boolean enabled = true;

        @Nonnull
        private final CommonHelper helper;

        public CheckStyleOptions(Project project) {
            super(project);
            helper = new CommonHelper(project, "checkstyle");
        }

        public void setDestination(File destination){
            helper.setDestination(destination);
        }

    }

    private class FindBugsOptions extends FindBugsExtension {
        public FindBugsOptions(Project project) {
            super(project);
        }
    }


    private class PmdOptions extends PmdExtension {
        public PmdOptions(Project project) {
            super(project);
        }
    }


    private class CoverageReportOptions {
    }

    private class CommonHelper{
        private final String name;
        private final Project project;
        File htmlFile;
        File xmlFile;
        String[] exclude = [];

        CommonHelper(Project project, String name){
            this.project = project;
            this.name = name;
        }

        void setDestination(File destination){
            htmlFile = DestinationUtil.getHtmlDestination(project, destination, name);
            xmlFile = DestinationUtil.getXmlDestination(project, destination, name);
        }
    }
}
