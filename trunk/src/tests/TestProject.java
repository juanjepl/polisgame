package tests;

import game.Hoplite;
import game.Player;
import game.Position;
import game.Project;
import game.ProjectGame;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestProject {
	@Mock
	Player mockPlayer;
	@Mock
	Position mockPosition;

	Player mockNullPlayer;
	Position mockNullPosition;

	String mockSysName;

	String mockName;

	Integer mockPrestige;

	Integer mockPrestigeToPosterity;

	Map<String, Integer> mockResourcesRequired;

	Boolean mockFinished;

	Boolean mockUsed;

	Project p;

	@Before
	public void setup() {
		mockNullPlayer = null;
		mockNullPosition = null;
		// mockSysName = "Hercules";
		// mockName = "Hercules";
		// mockPrestige = 3;
		// mockPrestigeToPosterity = 0;
		// mockFinished = true;
		// mockUsed = true;

		// p = new ProjectGame(mockSysName, mockName, mockPrestige,
		// mockPrestigeToPosterity, mockResourcesRequired);

		MockitoAnnotations.initMocks(this);

	}

	//
	// @Test
	// public void testProjectCreation() {
	// p = new ProjectGame(mockSysName, mockName, mockPrestige,
	// mockPrestigeToPosterity, mockResourcesRequired);
	// assert (p.getSysName().equals(mockSysName));
	// assert (p.getName().equals(mockName));
	// assert (p.getPrestige() == (mockPrestige));
	// assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
	// assert (p.getResourcesRequired().equals(mockResourcesRequired));
	//
	// }
	@Test(expected = NullPointerException.class)
	public void testNullSysName() {
		// Checks if Unit throws IllegalArgumentExceptions for null parameters
		Project p = new ProjectGame(null, mockName, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);
		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));

	}

	@Test(expected = NullPointerException.class)
	public void testNullName() {
		// Checks if Unit throws IllegalArgumentExceptions for null parameters
		Project p = new ProjectGame(mockSysName, null, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);
		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));

	}

	@Test(expected = NullPointerException.class)
	public void testNullPrestige() {
		// Checks if Unit throws IllegalArgumentExceptions for null parameters
		Project p = new ProjectGame(mockSysName, mockName, null,
				mockPrestigeToPosterity, mockResourcesRequired);
		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));

	}

	@Test(expected = NullPointerException.class)
	public void testNullPrestigeToPosterity() {
		// Checks if Unit throws IllegalArgumentExceptions for null parameters
		Project p = new ProjectGame(mockSysName, mockName, mockPrestige, null,
				mockResourcesRequired);
		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));

	}

	@Test(expected = NullPointerException.class)
	public void testNullResourcesRequired() {
		// Checks if Unit throws IllegalArgumentExceptions for null parameters
		Project p = new ProjectGame(mockSysName, mockName, mockPrestige,
				mockPrestigeToPosterity, null);
		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullPlayerUnitParameter() {
		Hoplite u2 = new Hoplite(mockNullPlayer, mockPosition);
		assert (u2.getOwner() == mockPlayer);
		assert (u2.getPosition() == mockPosition);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullPositionUnitParameter() {
		Hoplite u2 = new Hoplite(mockPlayer, mockNullPosition);
		assert (u2.getOwner() == mockPlayer);
		assert (u2.getPosition() == mockPosition);
	}

}
