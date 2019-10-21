11
.global _start
.data
buf: .skip 1024

.text
_start:
        pushq %rbp # From Func
        movq %rsp, %rbp # From Func
        subq $8, %rsp # From Func
        movq $10, %rax
        pushq %rax # From FuncCall
        pushq %rbp # From Func
        movq %rsp, %rbp # From Func
        subq $16, %rsp # From Func
        movq 24(%rsp), %rax # From Func
        movq %rax, -16(%rbp) # From IdDecl
        movq -16(%rbp), %rax # From IdUse
        pushq %rax
        movq $0, %rax
        movq %rax, %rbx
        popq %rax
        cmpq %rbx, %rax
        jne _others0.5344290552400405
        movq $0, %rax
        jmp _endIf0.5344290552400405
        _others0.5344290552400405:
        jmp _endIf0.5344290552400405
        _elseIf0.5344290552400405:
        jmp _endIf0.5344290552400405
        _else0.5344290552400405:
        _endIf0.5344290552400405:
        movq %rbp, %rsp
        popq %rbp
        pushq %rax # From FuncCall
        call print
        movq $0, %rax
        movq %rbp, %rsp
        popq %rbp
        movq $0, %rdi
        movq $60, %rax
        syscall
# Procedure to print number to stdout.
# C signature: void print(long int)
print:
        pushq %rbp
        movq %rsp, %rbp
        ### Convert integer to string (itoa).
        movq 16(%rbp), %rax
        leaq buf(%rip), %rsi    # RSI = write pointer (starts at end of buffer)
        addq $1023, %rsi
        movb $0x0A, (%rsi)      # insert newline
        movq $1, %rcx           # RCX = string length
        cmpq $0, %rax
        jge itoa_loop
        negq %rax               # negate to make RAX positive
itoa_loop:                      # do.. while (at least one iteration)
        movq $10, %rdi
        movq $0, %rdx
        idivq %rdi              # divide RDX:RAX by 10
        addb $0x30, %dl         # remainder + '0'
        decq %rsi               # move string pointer
        movb %dl, (%rsi)
        incq %rcx               # increment string length
        cmpq $0, %rax
        jg itoa_loop            # produce more digits
itoa_done:
        movq 16(%rbp), %rax
        cmpq $0, %rax
        jge print_end
        decq %rsi
        incq %rcx
        movb $0x2D, (%rsi)
print_end:
        movq $1, %rdi
        movq %rcx, %rdx
        movq $1, %rax
        syscall
        popq %rbp
        ret

