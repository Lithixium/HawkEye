package uk.co.oliwali.HawkEye.commands;

import uk.co.oliwali.HawkEye.Undo;
import uk.co.oliwali.HawkEye.util.Permission;

/**
 * Reverses the previous {@link RollbackCommand}
 * @author oliverw92
 */
public class UndoCommand extends BaseCommand {

	public UndoCommand() {
		name = "undo";
		bePlayer = true;
		usage = "<- reverses your previous rollback";
	}
	
	public boolean execute() {
		Thread thread = new Thread(new Undo(session));
		thread.start();
		return true;
	}

	public boolean permission() {
		return Permission.rollback(sender);
	}
	
}