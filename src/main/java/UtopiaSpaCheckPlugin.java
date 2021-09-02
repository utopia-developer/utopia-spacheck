import org.gradle.api.Plugin;
import org.gradle.api.Project;
import utils.OtherUtils;

/**
 * @author Utopia
 */
public class UtopiaSpaCheckPlugin implements Plugin<Project> {

    private static final String TASK_NAME = "utopia_check";

    private UtopiaSpaCheckExtension utopiaSpaCheckExtension;

    @Override
    public void apply(Project project) {
        if (isRequireSpaCheck(project)){
            OtherUtils.enableLog();
        }

        utopiaSpaCheckExtension = project.getExtensions().create("spacheck", UtopiaSpaCheckExtension.class, project);

        if (project == project.getRootProject()){

        }
    }

    private static boolean isRequireSpaCheck(Project project){
        return OtherUtils.isCommandContainTask(project, TASK_NAME);
    }
}
