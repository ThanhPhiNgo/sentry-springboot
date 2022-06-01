package phint2.research.sentryspringbootroot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phint2.research.sentryspringbootroot.entity.Test;
import phint2.research.sentryspringbootroot.repository.TestRepository;

@Service
public class SentryService {

	final TestRepository repository;

	@Autowired
	public SentryService(TestRepository repository) {
		this.repository = repository;
	}

	public void saveData() {
		Test test = new Test();
		test.setData("hello everybody");

		repository.save(test);
	}

	public Test getData() {
		return repository.findById(1).orElse(null);
	}
}
