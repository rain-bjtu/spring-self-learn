package resource.and.property;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class GetResource {

	public static void main(String[] args) throws IOException {
		testClasspathAsteriskPrefixLimit();
	}

	public static void testClasspathAsteriskPrefixLimit() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:overview.html");
		System.out.println(resources.length);
		resources = resolver.getResources("classpath*:over*.html");
		for (Resource r: resources) {
			System.out.println(r.getDescription());
		}
		System.out.println(resources.length);
		resources = resolver.getResources("classpath*:LICENS*");
		System.out.println(resources.length);
	}
}
