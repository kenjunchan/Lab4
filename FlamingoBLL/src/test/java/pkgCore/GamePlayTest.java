package pkgCore;
import pkgEnum.eGameType;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

public class GamePlayTest {

	private HashMap<UUID, Player> hmHagan = new HashMap<UUID, Player>();
	@Test
	public void test() {
				
		Player p1 = new Player("Ken", 1);
		Player p2 = new Player("Lissa", 2);
		Table t = new Table();
		t.AddPlayerToTable(p1);
		t.AddPlayerToTable(p2);
		t.CreateDeck(eGameType.BLACKJACK);
		
		ArrayList<Player> playerArray = new ArrayList<>();
		playerArray.add(p1);
		playerArray.add(p2);
		
		GamePlayBlackJack gpbj = new GamePlayBlackJack(t);
		
		gpbj.AddPlayersToGame(playerArray);
		
		assertEquals(gpbj.GetPlayerInGame(p1), p1); 
		
		gpbj.RemovePlayerFromGame(p1);
		assertEquals(gpbj.GetPlayerInGame(p1), null);
	}

}