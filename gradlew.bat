@echo off
setlocal
where gradle >nul 2>nul
if %ERRORLEVEL% EQU 0 (
  gradle %*
  exit /b %ERRORLEVEL%
)
echo Gradle is not installed. On Windows, install Gradle 8.14.4 or run this project in GitHub Actions/Linux where the text launcher can download Gradle.
exit /b 1
