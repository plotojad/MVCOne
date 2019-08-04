package mvcpack.view;

import mvcpack.controller.Controller;
import mvcpack.model.ModelData;

public interface View {
    void refresh(ModelData modelData);

    void setController(Controller controller);
}
