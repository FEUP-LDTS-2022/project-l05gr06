package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.InstructionController;
import tetrisRunner.controller.menu.SelectModeController;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.model.menu.SelectMode;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.InstructionViewer;
import tetrisRunner.viewer.menu.SelectGameModeViewer;

public class SelectModeState extends State<SelectMode>{

        public SelectModeState(SelectMode model) {
            super(model);
        }

        @Override
        protected Viewer<SelectMode> getViewer() {
            return new SelectGameModeViewer(getModel());
        }

        @Override
        protected Controller<SelectMode> getController() {
            return new SelectModeController(getModel());
        }


}
