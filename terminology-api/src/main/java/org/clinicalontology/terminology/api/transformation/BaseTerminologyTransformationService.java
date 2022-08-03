package org.clinicalontology.terminology.api.transformation;

import org.clinicalontology.terminology.api.service.TerminologyService;

public abstract class BaseTerminologyTransformationService {

    private TerminologyService terminologyService;

    public void setTerminologyService(TerminologyService terminologyService) {
        this.terminologyService = terminologyService;
    }

    public TerminologyService getTerminologyService() {
        return terminologyService;
    }
}
