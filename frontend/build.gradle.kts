plugins {
    id("com.moowork.node") version "1.3.1"
    base
}
repositories {
    mavenCentral()
}

node {
    download = false
    version = "16.13.0"
}

val projectDir = project.layout.projectDirectory
val frontendExportDir = "${rootProject.layout.projectDirectory}/app/frontend/"

tasks.create<Delete>("cleanFrontendResources") {
    description = "Delete all frontend files & folders that previously builds"
    group = "frontend"
    delete(fileTree(frontendExportDir))
    File(frontendExportDir).deleteRecursively()
}

tasks.register<Copy>("copyFrontendResources") {
    description = "Copy all frontend build resources to $frontendExportDir"
    group = "frontend"
    from("${projectDir}/dist/")
    into(frontendExportDir)
}

tasks.create<com.moowork.gradle.node.npm.NpmTask>("npmServe") {
    description = "Serve is a npm script command defined in package.json"
    group = "frontend"
    dependsOn("npmInstall")
    setArgs(listOf("run", "serve"))
}

tasks.create<com.moowork.gradle.node.npm.NpmTask>("npmBuild") {
    description = "build is a npm script command defined in package.json"
    group = "frontend"
    dependsOn("cleanFrontendResources")
    dependsOn("npmInstall")
    setArgs(listOf("run", "build"))
    finalizedBy("copyFrontendResources")
}

