public class Controller {
	public static void main(String[] args) {
		Button buttonA = new Button();
		Button buttonB = new Button();

		CDPlayer player = new CDPlayer();

		buttonA.setCommand(new CDPlayerOnCommand(player));
		buttonB.setCommand(new CDPlayerPlayMusicCommand(player));

		buttonA.press();
		buttonB.press();
	}
}

class Button {
	Command cmd;

	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}

	public void press() {
		cmd.execute();
	}
}

abstract class Command {
	abstract public void execute();
}

class CDPlayer {
	public void on() {
		System.out.println("CD player is on now.");
	}

	public void playMusic() {
		System.out.println("Playing music ...");
	}
}

class CDPlayerOnCommand extends Command {
	CDPlayer player;

	public CDPlayerOnCommand(CDPlayer player) {
		this.player = player;
	}

	public void execute() {
		player.on();
	}
}

class CDPlayerPlayMusicCommand extends Command {
	CDPlayer player;

	public CDPlayerPlayMusicCommand(CDPlayer player) {
		this.player = player;
	}

	public void execute() {
		player.playMusic();
	}
}