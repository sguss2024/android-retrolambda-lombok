/*
 * Copyright © 2010 Reinier Zwitserloot and Roel Spilker.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lombok.ast.syntaxChecks;

import java.util.List;

import lombok.ast.FloatingPointLiteral;
import lombok.ast.IntegralLiteral;
import lombok.ast.NullLiteral;
import lombok.ast.SyntaxProblem;
import lombok.ast.template.SyntaxCheck;

@SyntaxCheck
public class LiteralValidityTests {
	private final List<SyntaxProblem> problems;
	
	public LiteralValidityTests(List<SyntaxProblem> problems) {
		this.problems = problems;
	}
	
	//IntegralLiteral does its own 'literal too large' checking.
	public void checkIntegralLiteralValidity(IntegralLiteral node) {
		if (node.getErrorReasonForValue() != null) {
			problems.add(new SyntaxProblem(node, node.getErrorReasonForValue()));
		}
	}
	
	public void checkFloatingPointLiteralValidity(FloatingPointLiteral node) {
		if (node.getErrorReasonForValue() != null) {
			problems.add(new SyntaxProblem(node, node.getErrorReasonForValue()));
		}
	}
	
	public void checkNullLiteralValidity(NullLiteral node) {
		if (node.getErrorReasonForValue() != null) {
			problems.add(new SyntaxProblem(node, node.getErrorReasonForValue()));
		}
	}
}