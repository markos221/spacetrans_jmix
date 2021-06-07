package Context;

import io.jmix.core.accesscontext.SpecificOperationAccessContext;

public class UploadCsvFileContext extends SpecificOperationAccessContext {
    public static final String NAME = "rest.uploadCsvFile.enabled";

    public UploadCsvFileContext() {
        super(NAME);
    }
}
