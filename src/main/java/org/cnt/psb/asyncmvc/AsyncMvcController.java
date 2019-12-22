package org.cnt.psb.asyncmvc;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lixinjie
 * @since 2019-12-22
 */
@Slf4j
@RequestMapping("/mvc")
@RestController
public class AsyncMvcController {

	@RequestMapping("/sync")
	public String syncSlowProcess() throws Exception {
		long begin = System.currentTimeMillis();
		Thread ct = Thread.currentThread();
		Thread.sleep(10000);
		long end = System.currentTimeMillis();
		log.info("mvc={}, name={}, id={}", end - begin, ct.getName(), ct.getId());
		return "sync sleep for 10";
	}
	
	@RequestMapping("/async-ca")
	public Callable<String> asyncCallable() throws Exception {
		long begin = System.currentTimeMillis();
		Thread t = Thread.currentThread();
		
		Callable<String> call = () -> {
			long b = System.currentTimeMillis();
			Thread ct = Thread.currentThread();
			Thread.sleep(10000);
			long e = System.currentTimeMillis();
			log.info("async-ca={}, name={}, id={}", e - b, ct.getName(), ct.getId());
			return "async-ca sleep for 10";
		};
		
		long end = System.currentTimeMillis();
		log.info("mvc={}, name={}, id={}", end - begin, t.getName(), t.getId());
		return call;
	}
	
	@RequestMapping("/async-dr")
	public DeferredResult<String> asyncDeferredResult() throws Exception {
		long begin = System.currentTimeMillis();
		Thread t = Thread.currentThread();
		DeferredResult<String> dr = new DeferredResult<>();
		
		new Thread(() -> {
			long b = System.currentTimeMillis();
			Thread ct = Thread.currentThread();
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}
			long e = System.currentTimeMillis();
			log.info("async-dr={}, name={}, id={}", e - b, ct.getName(), ct.getId());
			dr.setResult("async-dr sleep for 10");
		}).start();
		
		long end = System.currentTimeMillis();
		log.info("mvc={}, name={}, id={}", end - begin, t.getName(), t.getId());
		return dr;
	}
}
