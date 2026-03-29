1. use an LLM to migrate apptemplate branch to your new app (Ask it to rename packages and strings that match your new project )
2. Modify email templates

Use the following prompt

I have renamed the current project. Help me do renaming (from appTemplate to NEW_PROJECT_NAME):
- Java Package: Rename com.softropic.apptemplate to com.softropic.NEW_PROJECT_NAME across all source and test files.
- Application Classes: Rename AppTemplateApplication to NEW_PROJECT_NAMEApplication and TestAppTemplateApplication to TestNEW_PROJECT_NAMEApplication.
- Build & Config: Update pom.xml, application.yaml, application-dev.yaml, and other configuration files.
- Frontend: Update package.json (productName) and related configuration.
- Documentation: Update ARCHITECTURE.md and other markdown files.
- Files & Directories: Rename project directories and files (e.g., readme_appTemplate.md to readme_NEW_PROJECT_NAME.md, apptemplate.iml to NEW_PROJECT_NAME.iml).
- Cleanup: Remove the target/ directory to ensure a clean build with the new project name.

Every occurrence of appTemplate, apptemplate, AppTemplate, and app-template should be replaced with nEW_PROJECT_NAME or NEW_PROJECT_NAME appropriately.



Summary of Changes

1. Dependencies (pom.xml):
    * Added micrometer-tracing-bridge-otel and opentelemetry-exporter-otlp for distributed tracing.
    * Added loki-logback-appender to support the existing Loki configuration in logback-spring.xml.
2. Configuration (application.yaml):
    * Enabled tracing with a 100% sampling probability (suitable for dev).
    * Configured the OTLP exporter to point to http://localhost:4318/v1/traces (Tempo).
    * Added common observation key-values like application: apptemplate.
3. Annotation Support:
    * Created ObservabilityConfig.java in com.softropic.apptemplate.config to enable the @Observed annotation.
    * Annotated MailService.java with @Observed(name = "mail.service") as a demonstration.
4. LGTM Stack Orchestration:
    * Created docker-compose-lgtm.yaml to spin up Grafana, Loki, Tempo, and Prometheus.
    * Provided prometheus.yml, tempo.yml, and grafana-datasources.yml for a "ready-to-use" local observability environment.

How to use
1. Start the LGTM stack:
   1     docker compose -f docker-compose-lgtm.yaml up -d
2. Run your application:
   Ensure your LOKI_API_KEY is set if you want logs to reach the remote Loki instance defined in your logback-spring.xml, or update it to point to the local http://localhost:3100/loki/api/v1/push.
3. Access Grafana:
   Open http://localhost:3000 to view metrics, logs, and traces. They are pre-linked via the provisioned datasources.
