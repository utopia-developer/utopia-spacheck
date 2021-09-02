package utils;

import org.gradle.api.Project;

import java.util.List;

import static org.gradle.internal.impldep.org.apache.commons.lang.StringUtils.containsIgnoreCase;

/**
 * @author Utopia
 */
public class OtherUtils {

    private static boolean isEnableLog = false;

    public static boolean isCommandContainTask(Project project, String taskName) {
        List<String> taskNames = project.getGradle().getStartParameter().getTaskNames();

        boolean contain = false;
        for (int i = 0; i < taskNames.size(); i++) {
            String name = taskNames.get(i);
            if (containsIgnoreCase(name, taskName)){
                contain = true;
                break;
            }
        }

        return contain;
    }

    public static void enableLog() {
        isEnableLog = true;
    }
}

