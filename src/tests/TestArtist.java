package tests;

import game.Artist;
import game.Player;
import game.Position;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestArtist {

	@Mock Player mockPlayer;
	@Mock Position mockPosition;

	
	String mockSysName;
	
	String mockName;
	
	Integer mockPrestige;
	
	Integer mockPrestigeToPosterity;
 	Map<String, Integer> mockResourcesRequired;

	Player mockNullPlayer;
	Position mockNullPosition;

	@Before
	public void setup() {
		mockNullPlayer = null;
		mockNullPosition = null;
		mockSysName = "systemName";
		mockName = "Name";
		mockPrestige = 2;
		mockPrestigeToPosterity = 12;
		mockResourcesRequired = new HashMap<String, Integer>();
		mockResourcesRequired.put("wine", 2);
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testArtistCreation() {
		Artist artista = new Artist(mockSysName, mockName, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (artista.getSysName().equals(mockSysName));
		assert (artista.getName().equals(mockName));
		assert (artista.getPrestige() == (mockPrestige));
		assert (artista.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (artista.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test(expected = NullPointerException.class)
	public void testNullSysName() {
		Artist artista = new Artist(null, mockName, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);
		assert (artista.getSysName().equals(mockSysName));
		assert (artista.getName().equals(mockName));
		assert (artista.getPrestige() == (mockPrestige));
		assert (artista.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (artista.getResourcesRequired().equals(mockResourcesRequired));
	}
	@Test (expected = NullPointerException.class)
	public void testNullName() {
		Artist artista = new Artist(mockSysName, null, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (artista.getSysName().equals(mockSysName));
		assert (artista.getName().equals(mockName));
		assert (artista.getPrestige() == (mockPrestige));
		assert (artista.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (artista.getResourcesRequired().equals(mockResourcesRequired));
	}
		
	@Test (expected = AssertionError.class)
	public void testNullPrestige() {
		Artist artista = new Artist(mockSysName, mockName, null,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (artista.getSysName().equals(mockSysName));
		assert (artista.getName().equals(mockName));
		assert (artista.getPrestige() == (mockPrestige));
		assert (artista.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (artista.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test (expected = AssertionError.class)
	public void testNullPrestigeToPosterity() {
		Artist artista = new Artist(mockSysName, mockName, null,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (artista.getSysName().equals(mockSysName));
		assert (artista.getName().equals(mockName));
		assert (artista.getPrestige() == (mockPrestige));
		assert (artista.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (artista.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test (expected = NullPointerException.class)
	public void testNullPrestigeResourcesRequired() {
		Artist artista = new Artist(mockSysName, mockName, mockPrestige,
				mockPrestigeToPosterity, null);

		assert (artista.getSysName().equals(mockSysName));
		assert (artista.getName().equals(mockName));
		assert (artista.getPrestige() == (mockPrestige));
		assert (artista.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (artista.getResourcesRequired().equals(mockResourcesRequired));
	}



}
