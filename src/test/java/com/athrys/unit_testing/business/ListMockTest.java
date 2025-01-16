package com.athrys.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ListMockTest {

	@Mock
	List<String> mock;

	@Test
	public void listMock() {
		when(mock.size()).thenReturn(5);
		
		assertEquals(5, mock.size());
	}

	@Test
	public void listMockDifVals() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("OwO");
		
		assertEquals("OwO", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParams() {
		when(mock.get(anyInt())).thenReturn("OwO");
		
		assertEquals("OwO", mock.get(0));
		assertEquals("OwO", mock.get(1));
	}

	@Test
	public void verificationBasics() {
		String value = mock.get(0);
		String value2 = mock.get(1);

		verify(mock).get(0);
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, times(1)).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(3);
	}

	@Test
	public void argumentCapturing() {
		mock.add("Data");
		mock.add("Data two, Data");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		assertEquals("Data", captor.getAllValues().get(0));
	}

	@Test
	public void mocking() {
		ArrayList<String> mockList = mock(ArrayList.class);

		System.out.println(mockList.get(0));
		mock.add("Test");
		System.out.println(mockList.get(0));
		System.out.println(mockList.size());

		when(mockList.size()).thenReturn(5);
		System.out.println(mockList.size());
	}
	
	@Test
	public void spying() {
		ArrayList<String> spy = spy(ArrayList.class);
		
		spy.add("Test");
		System.out.println(spy.get(0));
		spy.add("Test2");
		System.out.println(spy.get(0));
		System.out.println(spy.size());

		when(spy.size()).thenReturn(5);
		System.out.println(spy.size());
		spy.add("Test3");
		System.out.println(spy.size());	
		
		verify(spy).add("Test2");
	}
}
