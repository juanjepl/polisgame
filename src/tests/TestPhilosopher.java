package tests;

import game.Philosopher;
import game.Player;
import game.Position;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestPhilosopher {

	@Mock
	Player mockPlayer;
	@Mock
	Position mockPosition;

	
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
	public void testPhilosoPherCreation() {
		Philosopher p = new Philosopher(mockSysName, mockName, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test(expected = NullPointerException.class)
	public void testNullSysName() {
		Philosopher p = new Philosopher(null, mockName, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);
		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test(expected = NullPointerException.class)
	public void testNullName() {
		Philosopher p = new Philosopher(mockSysName, null, mockPrestige,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test(expected = AssertionError.class)
	public void testNullPrestige() {
		Philosopher p = new Philosopher(mockSysName, mockName, null,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test(expected = AssertionError.class)
	public void testNullPrestigeToPosterity() {
		Philosopher p = new Philosopher(mockSysName, mockName, null,
				mockPrestigeToPosterity, mockResourcesRequired);

		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));
	}

	@Test(expected = NullPointerException.class)
	public void testNullPrestigeResourcesRequired() {
		Philosopher p = new Philosopher(mockSysName, mockName, mockPrestige,
				mockPrestigeToPosterity, null);

		assert (p.getSysName().equals(mockSysName));
		assert (p.getName().equals(mockName));
		assert (p.getPrestige() == (mockPrestige));
		assert (p.getPrestigeToPosterity() == (mockPrestigeToPosterity));
		assert (p.getResourcesRequired().equals(mockResourcesRequired));
	}

}
