pipeline {
    agent any

    parameters {
        string(defaultValue: "", description: 'The browser to use for Selenium tests', name: 'BrowserPath')
    }

    stages {
        stage('Test') {
            steps {
                // Get code from GitHub
                git branch: 'test',
                    url: 'https://github.com/roskee/sample-testing-java.git'

                // Run maven test
                bat "mvn test -DBrowserPath=${params.BrowserPath}"
            }

            post {
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
}
