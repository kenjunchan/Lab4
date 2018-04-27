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
		Player p3 = new Player("Jane", 3);
		Player p4 = new Player("Doe", 4);
		
		Table t = new Table();
		t.AddPlayerToTable(p1);
		t.AddPlayerToTable(p2);
		
		Table t2 = new Table();
		t.AddPlayerToTable(p3);
		t.AddPlayerToTable(p4);
		
		t.CreateDeck(eGameType.BLACKJACK);
		t2.CreateDeck(eGameType.BLACKJACK);
		
		ArrayList<Player> playerArray = new ArrayList<>();
		playerArray.add(p1);
		playerArray.add(p2);
		
		ArrayList<Player> playerArray2 = new ArrayList<>();
		playerArray.add(p3);
		playerArray.add(p4);
		
		GamePlayBlackJack gpbj = new GamePlayBlackJack(t);
		
		gpbj.AddPlayersToGame(playerArray);
		assertEquals(gpbj.GetPlayerInGame(p1), p1); 
		assertEquals(gpbj.GetPlayerInGame(p2), p2); 
		
		gpbj.RemovePlayerFromGame(p1);
		assertEquals(gpbj.GetPlayerInGame(p1), null);
		gpbj.RemovePlayerFromGame(p2);
		assertEquals(gpbj.GetPlayerInGame(p2), null);
		
		gpbj.AddPlayersToGame(playerArray2);
		assertEquals(gpbj.GetPlayerInGame(p3), p3); 
		assertEquals(gpbj.GetPlayerInGame(p4), p4); 
		
		gpbj.RemovePlayerFromGame(p3);
		assertEquals(gpbj.GetPlayerInGame(p3), null);
		gpbj.RemovePlayerFromGame(p4);
		assertEquals(gpbj.GetPlayerInGame(p4), null);
	}

}