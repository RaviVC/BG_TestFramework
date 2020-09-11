pipeline {
    agent any
    stages {
        stage('validate') {
	   steps {
                echo 'validating..'
		git url: 'https://github.com/RaviVC/AutomationFramework.git'
		bat label: '', script: 'mvn validate'
           }
        }
		stage('compile') {
	   steps {
                echo 'compiling..'
		bat label: '', script: 'mvn compile'
           }
        }
        stage('codereview-pmd') {
	   steps {
                echo 'codereview..'
		bat label: '', script: 'mvn -P metrics pmd:pmd'
           }
	   post {
               success {
                   pmd canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '**/pmd.xml', unHealthy: ''
               }
           }		
        }
		stage('Functional-test') {
	   steps {
                echo 'unit test ..'
		bat label: '', script: 'mvn test'	
           }		
        }
		stage("SendEmail"){
		steps{
				echo 'Send Email Notification .. '
		emailext (to: 'ravivc197@gmail.com', replyTo: 'ravivc197@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: readFile("target/surefire-reports/emailable-report.html"),mimeType: 'text/html');
			}
		}
    }
}




