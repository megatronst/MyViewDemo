package f.p.p.customplugin
import org.gradle.api.Plugin
import org.gradle.api.Project

// 一个简单的自定义插件
class RunPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        target.android.applicationVariants.all {
            variant ->
                // 修改最终apk的路径及apk文件名
                variant.outputs.each {
                    output ->
                        def file = output.outputFile
                        file.toPath()
                        output.outputFile.renameTo(file.name.replace('.apk', '-test.apk'))

                }
                // 在instll过后自动运行
                if (variant.install) {
                    target.tasks.create(name: "run${variant.name.capitalize()}", dependsOn: variant.install) {
                        // 配置
                        description "Install the ${variant.description} and run the main launcher activity"
                        // 执行
                        doFirst {
                            // 获取对应activity的classpath
                            def classPath = variant.applicationId
                            def suffix = variant.buildType.applicationIdSuffix
                            if (suffix) {
                                classPath -= suffix
                                println classPath
                            }
                            // 获取具体的activity的class
                            def launtchClass = "${variant.applicationId}/${classPath}MainActivity"
                            println launtchClass
                            // 通过控制台命令让已连接的设备执行
                            target.exec {
                                executable = 'adb'
                                args = ['shell', 'am', 'start', '-N', launtchClass]
                            }

                        }
                    }
                }
        }


        // 过滤部分版本，加快build速度
        target.android.variantFilter {
            variant ->
                if (variant.name.equals('release')) {
                    variant.getFlavors().each {
                        flavor ->
                            if (flavor.name.equals('pay')) {
                                variant.setIgnore(true)
                            }
                    }
                }
        }
    }
}
