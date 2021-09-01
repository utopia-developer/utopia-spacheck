package utils;

import org.gradle.api.Project;

import java.io.File;

/**
 * @author Utopia
 */
public class DestinationUtil {

    public static File getHtmlDestination(Project project, File base, String type) {
        return getFileDestination(project, base, type, "html");
    }


    public static File getXmlDestination(Project project, File base, String type) {
        return getFileDestination(project, base, type, "xml");
    }

    /**
     * 指定路径生成文件
     * @param project 项目
     * @param base 文件
     * @param type 文件类型
     * @param extension 插件名
     * @return 生成的文件
     */
    public static File getFileDestination(final Project project, File base, final String type, String extension) {
        final String projectBuildPath = project.getBuildDir().getAbsolutePath();
        final String basePath = base.getAbsolutePath();

        if (basePath.startsWith(projectBuildPath)) {
            return new File(base, "reports/" + type + "." + extension);
        } else {
            return new File(base, "reports/" + project.getName() + "/" + type + "." + extension);
        }
    }

    /**
     * 生成文件路径
     * @param project 项目
     * @param base 文件
     * @param type 文件类型
     * @return 文件路径
     */
    public static File getDirDestination(Project project, File base, String type) {
        final String projectBuildPath = project.getBuildDir().getAbsolutePath();
        final String basePath = base.getAbsolutePath();

        if (basePath.startsWith(projectBuildPath)) {
            return new File(base, "reports/" + type + "/");
        } else {
            return new File(base, "reports/" + project.getName() + "/" + type + "/");
        }
    }
}
