package com.booklibrary.frontend.service;

import com.booklibrary.frontend.dto.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReaderService {

  @Value("${library.readers.endpoint}")
  private String readersEndpoint;

  @Autowired private RestTemplate restTemplate;

  public List<Reader> getReaders() {

    Reader[] readers = restTemplate.getForObject(readersEndpoint, Reader[].class);

    return Arrays.asList(Optional.ofNullable(readers).orElse(new Reader[0]));
  }

  public List<Reader> search(String lastName) {

    Reader[] readers =
        restTemplate.getForObject(readersEndpoint + "/search/" + lastName, Reader[].class);

    return Arrays.asList(Optional.ofNullable(readers).orElse(new Reader[0]));
  }

  public Reader getReader(int id) {

    Reader reader = restTemplate.getForObject(readersEndpoint + "/" + id, Reader.class);

    return reader;
  }

  public void createReader(Reader reader) {

    restTemplate.postForObject(readersEndpoint, reader, Reader.class);
  }

  public void delete(int id) {

    restTemplate.delete(readersEndpoint + "/" + id);
  }
}
