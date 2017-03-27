# TestGithub

#### Step 1: Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
#### Step 2: Add the dependency
```
dependencies {
	        compile 'com.github.value123:TestGithub:v1.0'
	}
```
#### notice: if you dependence sdk version not match this project sdk version,declare this in project AndroidManifes.xml
```
<uses-sdk tools:overrideLibrary="com.open.lib"/>
```