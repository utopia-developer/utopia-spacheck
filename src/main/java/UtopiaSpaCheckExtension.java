import org.gradle.api.Project;
import org.gradle.api.plugins.quality.CheckstyleExtension;
import org.gradle.api.plugins.quality.FindBugsExtension;
import org.gradle.api.plugins.quality.PmdExtension;
import utils.DestinationUtil;

import javax.annotation.Nonnull;
import java.io.File;

/**
 * @author Utopia
 */
public class UtopiaSpaCheckExtension {

    @Nonnull
    private final CheckStyleOptions checkStyle;

    @Nonnull
    private final FindBugsOptions findBugs;

    @Nonnull
    private final PmdOptions pmd;

    public UtopiaSpaCheckExtension(@Nonnull CheckStyleOptions checkStyle, @Nonnull FindBugsOptions findBugs, @Nonnull PmdOptions pmd) {
        this.checkStyle = checkStyle;
        this.findBugs = findBugs;
        this.pmd = pmd;
    }


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

        @Nonnull
        File getHtmlFile(){
            return helper.htmlFile;
        }

        void setExclude(String... exclude){
            helper.exclude = exclude;
        }

        @Nonnull
        String[] getExclude(){
            return helper.exclude;
        }
    }

    private class FindBugsOptions extends FindBugsExtension {

        boolean enabled = true;

        boolean reportHtml = true;
        boolean reportXml = false;

        @Nonnull
        private final CommonHelper helper;

        public FindBugsOptions(Project project) {
            super(project);
            helper = new CommonHelper(project, "findbugs");
        }

        void setDestination(File destination){
            helper.setDestination(destination);
        }

        @Nonnull
        File getHtmlFile(){
            return helper.htmlFile;
        }

        @Nonnull
        File getXmlFile(){
            return helper.xmlFile;
        }

        void setExclude(String... exclude){
            helper.exclude = exclude;
        }

        @Nonnull
        String[] getExclude(){
            return helper.exclude;
        }
    }


    private class PmdOptions extends PmdExtension {

        boolean enabled = true;

        @Nonnull
        private final CommonHelper helper;

        public PmdOptions(Project project) {
            super(project);
            helper = new CommonHelper(project, "pmd");
        }

        @Nonnull
        File getHtmlFile(){
            return helper.htmlFile;
        }

        void setExclude(String... exclude){
            helper.exclude = exclude;
        }

        @Nonnull
        String[] getExclude(){
            return helper.exclude;
        }
    }

    private class CommonHelper{
        @Nonnull
        private final String name;
        @Nonnull
        private final Project project;
        @Nonnull
        File htmlFile;
        @Nonnull
        File xmlFile;
        @Nonnull
        String[] exclude = {};

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
