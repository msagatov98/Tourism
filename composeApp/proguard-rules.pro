-keepnames @kotlin.Metadata class org.example.project.**
-keep class org.example.project.** { *; }
-keep interface org.example.project.** { *; }
-keepclassmembers class org.example.project.** { *; }

# for gson in chucker
# https://r8.googlesource.com/r8/+/refs/heads/main/compatibility-faq.md#troubleshooting-gson-gson
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken
-keepattributes AnnotationDefault,RuntimeVisibleAnnotations