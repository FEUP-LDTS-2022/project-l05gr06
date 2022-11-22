package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.SettingsController;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.SettingsViewer;



public class SettingsState extends State<Settings> {

    public SettingsState(Settings model) {
        super(model);
    }

    @Override
    protected Viewer<Settings> getViewer() {
        return new SettingsViewer(getModel());
    }

    @Override
    protected Controller<Settings> getController() {
        return new SettingsController(getModel());
    }
}
